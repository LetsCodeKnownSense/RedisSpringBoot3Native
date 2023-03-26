package com.knownsense.springredis.config;

import com.knownsense.springredis.ContractModel;
import com.knownsense.springredis.vo.ContractInfo;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import java.util.Date;


public class AppRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.serialization().registerType(ContractModel.class).registerType(ContractInfo.class).registerType(Date.class).registerType(Number.class).registerType(Long.class);
   }
}



