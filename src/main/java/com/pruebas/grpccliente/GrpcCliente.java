/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.grpccliente;


import com.pruebas.grpcserver.User.APIResponse;
import com.pruebas.grpcserver.User.LoginRequest;
import com.pruebas.grpcserver.userGrpc;
import com.pruebas.grpcserver.userGrpc.userBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 *
 * @author christianpineda
 */
public class GrpcCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8082).usePlaintext().build();
        userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("hola").setPassword("hola").build();
        APIResponse response = userStub.login(loginRequest);
        System.out.println(response.getResponsemessage());
        
    }
    
}
