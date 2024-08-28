create table if not exists category
(
    id serial primary key,  -- Muudeti 'serial', et ID automaatselt genereeruks
    name varchar(255),
    description varchar(255)
);

create table if not exists product
(
    id serial primary key,  -- Muudeti 'serial', et ID automaatselt genereeruks
    name varchar(255),
    description varchar(255),
    available_quantity double precision not null,  -- Parandatud 'double precision'
    price numeric(38, 2),
    category_id integer references category(id)  -- Parandatud võõrvõtme määramine
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;

