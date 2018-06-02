package com.asia;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2018-05-18.
 */
public class Test {

    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ImmutableList<String> immutableList = new ImmutableList.Builder<String>()
                .add("1")
                .add("2")
                .add("3")
                .add("4")
                .add("5")
                .add("6")
                .add("7")
                .add("8")
                .add("9")
                .add("0")
                .add("-")
                .add("=")
                .add("`")
                .build();

        List<ListenableFuture<String>> list = Lists.newArrayList();

        ListenableFuture<String> listenableFuture1 = service.submit(new Task(immutableList));
        list.add(listenableFuture1);
        ListenableFuture<String> listenableFuture2 = service.submit(new Task(immutableList));
        list.add(listenableFuture2);
        ListenableFuture<String> listenableFuture3 = service.submit(new Task(immutableList));
        list.add(listenableFuture3);
        ListenableFuture<String> listenableFuture4 = service.submit(new Task(immutableList));
        list.add(listenableFuture4);

        for(ListenableFuture<String> task : list) {
            Futures.addCallback(task, new MyFutureCallback(), service);
        }

        for(ListenableFuture<String> task : list) {
            String s = task.get();
            logger.info("get + " + s);
        }


        logger.info("ready shut down");



        while(!service.isTerminated()){
            System.out.println("thread is not over ,wait 0.5 seconds !");
            try{
                Thread.sleep(500) ;
            }catch(Exception e){
                e.printStackTrace() ;
            }
        }

        service.shutdown();

        logger.info("shut down");

        logger.info("执行其他任务");

    }

}

class Task implements Callable<String> {

    private static Logger logger = LoggerFactory.getLogger(Task.class);

    private ImmutableList<String> id;

    public Task(ImmutableList<String> id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        for(int i = 0 ; i < id.size() ; i++){

            logger.info("task"+i+" : "+ id.get(i));
        }

        return "call execute..";
    }

    public ImmutableList<String> getId() {
        return id;
    }

    public void setId(ImmutableList<String> id) {
        this.id = id;
    }
}

class MyFutureCallback implements FutureCallback<String>{

    private static Logger logger = LoggerFactory.getLogger(MyFutureCallback.class);

    @Override
    public void onSuccess(String result) {
        logger.info(result);
        logger.info("onSuccess: " + result);
    }

    @Override
    public void onFailure(Throwable t) {
        logger.info("onFailure: " + t.toString());
    }
}
