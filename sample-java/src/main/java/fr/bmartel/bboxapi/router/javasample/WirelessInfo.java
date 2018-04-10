package fr.bmartel.bboxapi.router.javasample;

import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.result.Result;
import fr.bmartel.bboxapi.router.BboxApiRouter;
import fr.bmartel.bboxapi.router.model.Wireless;
import kotlin.Triple;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WirelessInfo {

    public static void main(String args[]) throws InterruptedException {
        BboxApiRouter bboxapi = new BboxApiRouter();
        bboxapi.setPassword("admin");

        //asynchronous call
        CountDownLatch latch = new CountDownLatch(1);
        bboxapi.getWirelessInfo(new Handler<List<Wireless>>() {
            @Override
            public void failure(Request request, Response response, FuelError error) {
                error.printStackTrace();
                latch.countDown();
            }

            @Override
            public void success(Request request, Response response, List<Wireless> data) {
                System.out.println(data);
                latch.countDown();
            }
        });
        latch.await();

        //synchronous call
        Triple<Request, Response, Result<List<Wireless>, FuelError>> data = bboxapi.getWirelessInfoSync();
        Request request = data.getFirst();
        Response response = data.getSecond();
        Result<List<Wireless>, FuelError> obj = data.getThird();
        System.out.println(obj.get());
    }
}
