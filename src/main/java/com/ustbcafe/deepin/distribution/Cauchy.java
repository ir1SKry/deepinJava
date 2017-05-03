package com.ustbcafe.deepin.distribution;

import cern.jet.random.Distributions;
import cern.jet.random.Normal;
import cern.jet.random.engine.MersenneTwister;
import cern.jet.random.engine.RandomEngine;
import cern.jet.random.engine.RandomGenerator;

import java.util.Date;

/**
 * Created by Rudy Steiner on 2017/4/12.
 */
public class Cauchy {
  public static void main(String[] args){
      RandomEngine generator=new MersenneTwister(new Date());
      Normal normal=new Normal(0,0.15,generator);
      double cauchy,guassian;
      double segma=0.1;
      for(int i=10000;i>0;i--){
          cauchy= segma*Distributions.nextCauchy(generator);
          guassian=normal.nextDouble();
          System.out.printf("%f,%f \n",cauchy,guassian);
      }
  }
}
