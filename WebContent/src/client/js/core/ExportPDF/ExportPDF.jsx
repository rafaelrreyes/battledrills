import React, { useState } from "react";
import { BlobProvider } from "@react-pdf/renderer";
import { Icon, Spinner, TooltipPlacement } from "CORE";
import { MaterialIconNames, BLUE_GREY, GREY } from "UTILITIES";
import { Document, Page, Text, Image, StyleSheet, Font } from "@react-pdf/renderer";
import robotoFont from "FONTS/Roboto-Regular.woff";
import "./ExportPDF.scss";

Font.register({
	family: "Roboto",
	src: robotoFont,
	fontStyle: "normal",
	fontWeight: "normal"
});

const styles = StyleSheet.create({
	page: {
		paddingTop: 35,
		paddingBottom: 65,
		paddingHorizontal: 35
	},
	image: {
		backgroundColor: BLUE_GREY[900],
		marginVertical: 8
	},
	title: {
		fontSize: 20,
		textAlign: "center",
		fontFamily: "Roboto",
		color: GREY[900]
	},
	info: {
		fontSize: 14,
		textAlign: "center",
		fontFamily: "Roboto",
		color: GREY[900]
	},
	pageNumber: {
		position: "absolute",
		fontSize: 12,
		bottom: 30,
		left: 0,
		right: 0,
		textAlign: "center",
		color: GREY[900]
	}
});

const PDF = ({ images, title, name, type }) => {
	const renderImages = () => {
		return images.map((base64Image, index) => {
			return <Image src={base64Image} style={styles.image} key={index} />;
		});
	};

	return (
		<Document>
			<Page style={styles.page}>
				{title && <Text style={styles.title}>{title}</Text>}
				{name && <Text style={styles.info}>Name: {name}</Text>}
				{type && <Text style={styles.info}>Type: {type}</Text>}
				{renderImages()}
				<Text
					style={styles.pageNumber}
					render={({ pageNumber, totalPages }) => `${pageNumber} / ${totalPages}`}
					fixed
				/>
			</Page>
		</Document>
	);
};

/**
 * https://github.com/diegomura/react-pdf/issues/420#issuecomment-607197243
 * ExportPDF shows icon to click to download a PDF
 * Shows a spinner while BlobProvider loads
 *
 * @param images array of base64 images (charts)
 * @param title title at the top of the PDF
 * @param name sub-name underneath title and doubles as name of the PDF file (if undefined, button is disabled)
 * @param type sub-type underneath name
 */
export const ExportPDF = ({ images, title, name, type }) => {
	const [isShowBlobProvider, setIsShowBlobProvider] = useState(false);

	const downloadFullPDF = (blob, filename) => {
		const a = document.createElement("a");
		document.body.appendChild(a);
		a.style = "display: none";
		a.href = window.URL.createObjectURL(blob);
		a.download = filename;
		a.click();
		window.URL.revokeObjectURL(a.href);
		a.remove();
		setIsShowBlobProvider(false);
	};

	return (
		<div className="export-pdf">
			{isShowBlobProvider ? (
				<BlobProvider
					document={<PDF images={images} title={title} name={name} type={type}></PDF>}
					fileName={`${name}.pdf`}
				>
					{({ blob, url, loading, error }) => {
						if (!loading) {
							downloadFullPDF(blob, `${name}.pdf`);
						}
						return <Spinner size="xs"></Spinner>;
					}}
				</BlobProvider>
			) : (
				<button
					disabled={name === undefined}
					className="no-button"
					onClick={() => {
						setIsShowBlobProvider(true);
					}}
				>
					<Icon tooltip="Export to PDF" tooltipPlacement={TooltipPlacement.TOP}>
						{MaterialIconNames.DOWNLOAD}
					</Icon>
				</button>
			)}
		</div>
	);
};
