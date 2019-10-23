package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

public class MyService extends Service
{

    String info="";
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return stub;
    }

    private IMyAidlInterface.Stub stub=new IMyAidlInterface.Stub() {


        @Override
        public int add(int i, int j) throws RemoteException {
            return i+j;
        }

        @Override
        public String getUserInfo(UserInfo userinfo) throws RemoteException {
            String resultString="name:"+userinfo.getName()+" "+"adress:"+userinfo.getAdress()+" "+"age:"+userinfo.getAge();
            return resultString;
        }

        @Override
        public void getaList(String[] list) throws RemoteException {
            list[0]="服务端赋值信息:"+info;
        }

        @Override
        public void setaList(String[] list) throws RemoteException {
            if(list.length>0)
                info=list[0];
        }

        @Override
        public void gettList(String[] list) throws RemoteException {
            String totalString="";
            /**
             * 从客户端取得的信息
             */
            String receviceFromClientString="";
            for(int i=0;i<list.length;i++)
            {
                receviceFromClientString+=list[i];
            }
            /**
             * 从服务端返回的信息
             */
            totalString+="从客户端收到的信息为："+receviceFromClientString+" \n在此我们新增一段返回信息:good";
            list[0]=totalString;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

}
