package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Order> list = new ArrayList<>();

		System.out.print("Number of customers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Enter the client #" + i + " data: \n");
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("E-mail: ");
			String email = sc.next();
			Client client = new Client(name, email);

			System.out.print("Enter order data: \n");
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());
			Order order = new Order(new Date(), status, client);

			System.out.print("How many items in this order? ");
			int x = sc.nextInt();
			for (int y = 1; y <= x; y++) {
				System.out.println("Enter #" + y + " item data: ");
				System.out.print("Product name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.print("Product price: ");
				double productPrice = sc.nextDouble();
				Product product = new Product(productName, productPrice);
				
				System.out.print("Quantity: ");
				int quantity = sc.nextInt();
				OrderItem orderitem = new OrderItem(quantity, productPrice, product);
				order.addItem(orderitem);
				list.add(order);
			}
		}
		
		for(Order order : list) {
			System.out.println();
			System.out.println("ORDER SUMMARY:");
			System.out.println(order);
		}

		sc.close();

	}

}
