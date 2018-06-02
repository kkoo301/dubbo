package com.asia;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2018-05-19.
 */
public class Test1 {

    private static Logger logger = LoggerFactory.getLogger(Test1.class);

    AtomicInteger integer = new AtomicInteger();

    public static void main(String ar[]){
        Long startTime = System.currentTimeMillis();
        Test1 t = new Test1();
        t.excute();
        logger.info("任务执行完毕，执行时间： "+ (System.currentTimeMillis() - startTime));
        //t.excute();
        //t.excute();
    }

    public void excute(){
        ExecutorService es = Executors.newFixedThreadPool(20);
        logger.info("******************************** 1 isTerminated : ===> "+ es.isTerminated());
        try {
            List<Future<Person>> futures = es.invokeAll(getAllCallable());
            //Person person = es.invokeAny(getAllCallable(),1300,TimeUnit.MILLISECONDS);
            for(Future<Person> f: futures){

                System.out.println("预期任务执行完时间：4s");
                Person person = f.get(4,TimeUnit.SECONDS);
                logger.info("future result : " + person.toString());
            }

            logger.info("isTerminated : ===> "+ es.isTerminated());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }

        do {
            logger.info("******************************** 2 isTerminated : ===> "+ es.isTerminated());
        }while (es.isTerminated());


    }

    private List<Callable<Person>> getAllCallable(){
        List<Callable<Person>> list = Lists.newArrayList();

        for(int i = 0 ; i < 23 ; i++){
            list.add(new MyTask("task" + integer.getAndIncrement()));
        }

        return list;
    }


}

class MyTask implements Callable<Person>{

    private static Logger logger = LoggerFactory.getLogger(MyTask.class);

    private String taskSeq;

    public MyTask(String taskSeq) {
        this.taskSeq = taskSeq;
    }

    @Override
    public Person call() throws Exception {
        logger.info("开始加载广告信息");

        Random r = new Random();
        int randomTime = new Random().nextInt(5) + 1;
        Thread.sleep(randomTime * 1000);
        logger.info("正常加载广告耗时:" + randomTime +"s");
        Person p = new Person(UUID.randomUUID().toString() , r.nextInt(88));
        logger.info("task : " + taskSeq + "   result : " + p);
        return p;
    }

    public String getTaskSeq() {
        return taskSeq;
    }

    public void setTaskSeq(String taskSeq) {
        this.taskSeq = taskSeq;
    }
}
class Person{

    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id  + '\'' +
                '}';
    }
}

