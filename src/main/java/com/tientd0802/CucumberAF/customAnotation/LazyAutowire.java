package com.tientd0802.CucumberAF.customAnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Autowired
@Lazy
public @interface LazyAutowire {
}
