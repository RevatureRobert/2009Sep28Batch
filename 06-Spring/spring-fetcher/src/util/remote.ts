export const getAllPizzas = async () => {
    const response = await fetch("http://localhost:8081/Spring-mvc/pizza.app");
    const json = await response.json();
    return json;
}