package delivery.app.order;

import delivery.app.utils.SystemVariablesManager;

public abstract class BaseOrderDecorator extends Order{
    protected Order order;
    protected SystemVariablesManager variables;

    public BaseOrderDecorator(Order order){
        super(order);
        this.order = order; 
        variables = SystemVariablesManager.getInstance();

    }
}
