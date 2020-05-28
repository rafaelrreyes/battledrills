const HtmlWebPackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const OptimizeCssAssetsPlugin = require("optimize-css-assets-webpack-plugin");
const path = require("path");
const isDevMode = process.env.NODE_ENV;

module.exports = {
	entry: "./src/index.js",
	output: {
		filename: "[name].bundle.js",
		path: path.resolve(__dirname, "../")
	},
	module: {
		rules: [
			{
				test: /\.(js|jsx)$/,
				exclude: /node_modules/,
				use: {
					loader: "babel-loader"
				}
			},
			{
				test: /\.(css|scss)$/,
				use: [
					{
						loader: "css-hot-loader"
					},
					MiniCssExtractPlugin.loader,
					{
						loader: "css-loader"
					},
					{
						loader: "sass-loader"
					}
				]
			}
		]
	},
	resolve: {
		alias: {
			CSS: path.resolve(__dirname, "../src/client/css/"), // @import "~CSS/..."
			UTILITIES: path.resolve(__dirname, "../src/client/js/utilities/"), // import * from "UTILITIES/..."
			REDUX: path.resolve(__dirname, "../src/client/js/redux/"), // import * from "REDUX/..."
			CORE: path.resolve(__dirname, "../src/client/js/core/"), // import * from "CORE/..."
			COMPONENTS: path.resolve(__dirname, "../src/client/js/components/"), // import * from "COMPONENTS/..."
			HOOKS: path.resolve(__dirname, "../src/client/js/hooks/"), // import * from "HOOKS/..."
			IMAGES: path.resolve(__dirname, "../src/client/lib/images/"), // import * from "IMAGES/..."
			FONTS: path.resolve(__dirname, "../src/client/lib/fonts/"),
			JOINT: path.resolve(__dirname, "../src/client/js/joint/") // import * from "JOINT/..."
		},
		extensions: [".js", ".jsx", "*"]
	},
	plugins: [
		new CleanWebpackPlugin({
			verbose: true,
			cleanOnceBeforeBuildPatterns: ["./fonts/", "./images/", "./index.html", "./main.bundle.js", "./main.css"]
		}),
		new HtmlWebPackPlugin({
			template: "./src/index.html",
			filename: "./index.html"
		}),
		new MiniCssExtractPlugin({
			filename: "[name].css",
			chunkFilename: "[id].css"
		}),
		new OptimizeCssAssetsPlugin({
			cssProcessor: require("cssnano"),
			cssProcessorPluginOptions: {
				preset: ["default", { discardComments: { removeAll: true } }]
			},
			canPrint: true
		})
	]
};
