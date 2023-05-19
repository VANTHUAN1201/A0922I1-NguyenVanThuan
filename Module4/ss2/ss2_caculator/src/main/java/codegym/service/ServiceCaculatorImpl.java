package codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceCaculatorImpl implements IServiceCaculator{
    public double caculator(double item1, double item2, String caculation) {
        switch (caculation){
            case "+":
                return item1+item2;
            case "-":
                return item1-item2;
            case "*":
                return item1*item2;
            case "/":
                return item1/item2;
            default:
                return 0;
        }
    }
}
