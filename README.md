# epam-order-service
This repo consists of 3 projects(microservices) interacting with each other through FeignClient as per the assignment description.
Eureka Server is utilised here for service registry and discovery.
Order Item service is used to create and retrieve item details for a particular Service
Order Service is used to create an Order and fetch Order details with all its associated items.

POST:
Create an order
/service/orders/

Input Json:
{
  "customerName":"Abhishek S",
  "orderDate":"01/01/2020",
  "shippingAddress":"",
  "items":
  [{
        "productName": "shirts",
        "quantity": "21"
    },
    {
        "productName": "jeans",
        "quantity": "23"
    }],
    "totalAmount":"432"
}


GET:
/service/order/{id}

