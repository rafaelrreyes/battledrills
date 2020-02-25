const merge = require("webpack-merge");
const common = require("./webpack.common.js");

module.exports = merge(common, {
	mode: "production",
	module: {
		rules: [
			{
				test: /\.(woff|woff2|ttf)$/,
				use: [
					{
						loader: "file-loader",
						options: {
							name: "[name].[ext]",
							outputPath: "fonts"
						}
					}
				]
			},
			{
				test: /\.(png|jpeg|jpg)$/,
				use: [
					{
						loader: "file-loader",
						options: {
							name: "[name].[ext]",
							outputPath: "images"
						}
					}
				]
			}
		]
	}
});
