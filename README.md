# Spring Boot, JPA, API Rest
Crud usando Spring
## Pré-requisitos
- [x] Java JDK 17 ou superior
- [x] Apache Maven
## Rodando o projeto
**1. Clone o projeto**
```bash
git clone https://github.com/wander740/spring-api-crud.git
```
**2. Compila as classes**
```bash
mvn compile
```
**3. Execute o aplicativo usando o maven**

```bash
mvn spring-boot:run
```
O aplicativo será executado no [http://localhost:8080](http://localhost:8080/)

## Usando a API Rest

### News

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/news| Obtenha todas as postagens | |
| GET    | /api/news/{id} | Obter postagem por ID | |
| GET    | /api/news/searchByName | Procura as postagem por uma string | |
| POST   | /api/news| Criar nova postagem | [JSON](#postcreate) |
| PUT    | /api/news/{id} | Atualizar postagem | [JSON](#postupdate) |
| DELETE | /api/news/{id} | Excluir postagem | |

### Category

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/category| Obtenha todas as categorias| |
| GET    | /api/category/{id} | Obter categoria por ID | |
| POST   | /api/category| Criar nova categoria | [JSON](#categorycreate) |

## JSON válidos
##### <a id="postcreate">Criar News -> /api/news</a>
```json
{
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
	"text": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto",
	"category_id": 1
}
```

##### <a id="postupdate">Atualizar News -> /api/news/{id}</a>
```json
{
	"title": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED",
	"text": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED",
	"category_id": 1
}
```
##### <a id="categorycreate">Criar Categoria -> /api/category</a>
```json
{
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
}
```