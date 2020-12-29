export const getAllPizzas = async () => {
    const response = await fetch("http://localhost:8080/pizza.app");
    const json = await response.json();
    return json;
}