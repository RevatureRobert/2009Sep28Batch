import cat from './index';

//a description of what you're going to test
//the name of the test, make it descriptive as possible
test('concat should return "hey cat" when "hey " and "cat" are args', () => {
    expect(cat("hey ", "cat")).toBe("hey cat");
  });
  