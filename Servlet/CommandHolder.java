package controller.servlet;

import controller.commands.Command;
import controller.commands.order.AdminGetAllOrdersCommand;
import controller.commands.order.AdminUpdateOrderCommand;
import controller.commands.order.AdminUpdateOrderStatusCommand;
import controller.commands.order.DeleteOrderCommand;
import controller.commands.orderProduct.DeleteProductFromOrderCommand;
import controller.commands.product.*;
import controller.commands.user.*;
import controller.commands.userOrder.UserGetAllUserOrdersCommand;

import java.util.HashMap;
import java.util.Map;

import static model.constants.UrlHolder.*;

public class CommandHolder {

    protected static final String DELIMITER = ":";
    protected static final String GET = "GET";
    protected static final String POST = "POST";

     private Map<String, Command> commands = new HashMap<>();

    CommandHolder() {
        init();
    }

    private void init() {

        commands.put(GET + DELIMITER + LOCALE, new ChangeLocaleCommand());
        commands.put(GET + DELIMITER + LOGIN, new LoginCommand());
        commands.put(GET + DELIMITER + LOGOUT, new LogoutCommand());
        commands.put(GET + DELIMITER + PRODUCTS, new GetTenProductsCommand());
    }

    public Command findCommand(String commandKey) {
        return commands.getOrDefault(commandKey, (req, resp) -> INDEX);
    }
}
