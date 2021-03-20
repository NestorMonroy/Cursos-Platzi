import { getDataFromApi } from "../promises";

describe("Probar Async/Await", () => {
  test("Realizar una petición a una API", async () => {
    const api = "https://rickandmortyapi.com/api/character/";
    const getRick = "https://rickandmortyapi.com/api/character/1";

    const data = await getDataFromApi(api);
    expect(data.results.length).toBeGreaterThanOrEqual(0);

    const data2 = await getDataFromApi(getRick);
    expect(data2.name).toEqual("Rick Sanchez");
  });
});
