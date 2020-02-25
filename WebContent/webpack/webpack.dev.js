const merge = require("webpack-merge");
const common = require("./webpack.common.js");
const webpack = require("webpack");
const path = require("path");

module.exports = merge(common, {
	mode: "development",
	devtool: "eval-source-map",
	devServer: {
		contentBase: path.join(__dirname, "../src/client/lib/"),
		port: 3000,
		proxy: {
			"/battledrills/**": {
				target: "https://localhost:8443",
				secure: false
			}
		},
		historyApiFallback: true,
		hot: true,
		https: true
	},
	module: {
		rules: [
			{
				test: /\.(woff|woff2|ttf|png|jpeg|jpg)$/,
				use: [
					{
						loader: "file-loader",
						options: {
							name: "[name].[ext]"
						}
					}
				]
			}
		]
	},
	plugins: [new webpack.HotModuleReplacementPlugin()]
});
