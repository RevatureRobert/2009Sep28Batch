import go from "./network";

test("should get back google", async () => {
  expect(await go()).toContain("google");
});
