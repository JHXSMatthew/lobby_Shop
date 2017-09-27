package com.mcndsj.lobbyShop.managers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Matthew on 7/07/2016.
 */
public class ThreadManager {

    private static ThreadManager manager;
    private ExecutorService service ;

    public ThreadManager(){
        service = Executors.newSingleThreadExecutor();
    }

    public void run(Runnable r){
        service.execute(r);
    }

    public static ThreadManager get(){
        if(manager == null){
            manager = new ThreadManager();
        }
        return manager;
    }
}
