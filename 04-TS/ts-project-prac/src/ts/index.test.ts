import cat from './index';

test('concat should return "hey cat" when "hey " and "cat" are args', () => {
	expect(cat("hey ", "cat")).toBe("hey cat");
})