async function fetchGoogle() {
	const fetched = await fetch('http://google.com');
	const text = await fetched.text();
	return text;
}

export default fetchGoogle;