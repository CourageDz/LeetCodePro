import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {

        Pairing pairing = PairingFactory.getPairing(new TypeACurveGenerator(160, 160).generate());

        String x = "15892250435992847095463870807551166628757393618893";
        int xI = 12512541;
        BigInteger xB = new BigInteger(x);
        System.out.println(xB.pow(4));
        byte[] xb = intToByteArray(xI);
        Element xZr = pairing.getZr().newElement(xI);
//        xZr.setFromBytes(xb);
        System.out.println("xZr:" + xZr);
        System.out.println("-xZr:" + xZr.negate());
        System.out.println("xZr^-1:" + xZr.invert());
        Element xe = pairing.getG1().newRandomElement();
        System.out.println(xe.pow(xB));
        System.out.println(xe.powZn(xZr));
        System.out.println(xB);
    }

    public static byte[] intToByteArray(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

}
