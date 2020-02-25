const acronyms = ["ied", "vbied", "svbied"];

export const parseAllTypes = (types) => {
	let parsedTypes = [];
	types.forEach((type, index) => {
		let words = type.split("_");
		words.forEach((word, i) => {
			if (acronyms.includes(word)) {
				words[i] = word.toUpperCase();
			} else {
				words[i] = word.charAt(0).toUpperCase() + word.slice(1);
			}
		});
		parsedTypes.push(words.join(" "));
	});
	return parsedTypes;
};

export const parseType = (type) => {
	let words = type.split("_");
	words.forEach((word, i) => {
		if (acronyms.includes(word)) {
			words[i] = word.toUpperCase();
		} else {
			words[i] = word.charAt(0).toUpperCase() + word.slice(1);
		}
	});
	return words.join(" ");
};

export const undoParsedType = (type) => {
	if (type) {
		let words = type.split(" ");
		words.forEach((word, i) => {
			words[i] = word.toLowerCase();
		});
		return words.join("_");
	} else {
		return type;
	}
};
