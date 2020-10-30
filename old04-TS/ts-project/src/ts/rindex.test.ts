import concat from './index';

test('concat should return "hey cat" when "hey and "cat" are args', () => {
    expect(concat("hey ","cat")).toBe("hey cat");
});