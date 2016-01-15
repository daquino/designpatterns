create table if not exists products(
  sku  varchar(50),
  name   varchar(100),
  price double
);

create table if not exists orders(
  orderId int,
  cusid   varchar(50)
);

create table if not exists items(
  orderId int,
  sku     varchar(50),
  quantity int
);