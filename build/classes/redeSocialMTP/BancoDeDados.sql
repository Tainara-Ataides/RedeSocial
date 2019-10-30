CREATE TABLE pessoa(
	id SERIAL NOT NULL,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(45) NOT NULL,
	senha VARCHAR(45) NOT NULL,
	cidade_estado VARCHAR(45),
	foto BYTEA,
	
	PRIMARY KEY (id)
);

CREATE TABLE post(
	id SERIAL NOT NULL,
	texto TEXT NOT NULL,
	pessoa_id INT NOT NULL,
	imagem BYTEA,
data_post TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);

CREATE TABLE like_post(
	id SERIAL NOT NULL,
	pessoa_id INT NOT NULL,
	post_id INT NOT NULL,
	data_like TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (pessoa_id) REFERENCES pessoa (id),
	FOREIGN KEY (post_id) REFERENCES post (id)
);