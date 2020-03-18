package test;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        String s0 = "740885373121112196049638586958643672674314946221";
        String s1 = "1363392976700259085153530473664808266069411419893";
        String s2 = "1078928940096103094114413317783035209658532050033";
        String s3 = "930192092896089637216954413567331882820598133829";
        String result = "1013765620624451925052138719799860648500196994497310003727780914806112837403603077454649483843647327118496287881934271823654325080917234145509454298334695415685435590872667330392817767123742021";
        BigInteger bi0 = new BigInteger(s0);
        BigInteger bi1 = new BigInteger(s1);
        BigInteger bi2 = new BigInteger(s2);
        BigInteger bi3 = new BigInteger(s3);
        BigInteger resule = bi0.multiply(bi1).multiply(bi2).multiply(bi3);
        System.out.println(resule.toString());
        System.out.println(result.equals(resule.toString()));
    }
}
