package cn.itcast.jk.controller.cargo.outproduct;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.OutProductVo;
import cn.itcast.util.DownloadUtil;

@Controller
public class OutProductController extends BaseController {
	@Autowired
	private OutProductService ops;

	// 转向输入年月的界面
	@RequestMapping("/cargo/outproduct/toedit.action")
	public String toedit() {
		return "cargo/outproduct/jOutProduct.jsp";
	}

	// 显示出货表
	@RequestMapping("/cargo/outproduct/print.action")
	public void print(String inputDate, HttpServletResponse response, HttpServletRequest request) throws IOException {// intputDate格式:yyyy-MM
		List<OutProductVo> dataList = ops.find(inputDate);
		int rowNum = 0;// 行号
		int colNum = 0;// 列号

		Workbook workbook = new HSSFWorkbook();// HSSF操作Excel2003以下版本
		Sheet sheet = workbook.createSheet();
		Row nRow = null;
		Cell nCell = null;
		CellStyle nStyle = workbook.createCellStyle();
		Font nFont = workbook.createFont();

		// 设置表格宽度
		sheet.setColumnWidth(0, 1 * 300);// 列宽
		sheet.setColumnWidth(1, 26 * 300);// 列宽
		sheet.setColumnWidth(2, 12 * 300);// 列宽
		sheet.setColumnWidth(3, 29 * 300);// 列宽
		sheet.setColumnWidth(4, 10 * 300);// 列宽
		sheet.setColumnWidth(5, 12 * 300);// 列宽
		sheet.setColumnWidth(6, 8 * 300);// 列宽
		sheet.setColumnWidth(7, 10 * 300);// 列宽
		sheet.setColumnWidth(8, 10 * 300);// 列宽
		sheet.setColumnWidth(9, 8 * 300);// 列宽

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 9));
		nRow = sheet.createRow(rowNum);
		nRow.setHeightInPoints(36);

		nCell = nRow.createCell(1);
		nCell.setCellValue(inputDate.replace("-", "年") + "月出货表");
		nCell.setCellStyle(this.bigTitle(workbook, nStyle, nFont));

		rowNum++;
		nRow = sheet.createRow(rowNum);
		String[] titles = new String[] { "客户", "订单号", "货号", "数量", "工厂", "附件", "工厂交期", "船期", "贸易条款" };
		for (int i = 0; i < titles.length; i++) {
			nCell = nRow.createCell(i + 1);
			nCell.setCellValue(titles[i]);
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
		}
		// 处理数据
		rowNum++;

		for (int i = 0; i < dataList.size(); i++) {
			colNum = 1;
			nRow = sheet.createRow(rowNum);
			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getCustomName());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getContractNo());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getProductNo());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getCnumber());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getFactoryName());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getExts());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getDelivery_preriod());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getShip_time());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			nCell = nRow.createCell(colNum);
			nCell.setCellValue(dataList.get(i).getTradeTerms());
			nCell.setCellStyle(this.Title(workbook, nStyle, nFont));
			colNum++;

			rowNum++;
		}

		// OutputStream os = new FileOutputStream(new File("F:\\testPOI.xls"));
		// workbook.write(os);
		// os.flush();
		// os.close();

		// 下载
		DownloadUtil dU = new DownloadUtil();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		workbook.write(os);
		dU.download(os, response, "出货表.xls");
	}

	public CellStyle bigTitle(Workbook workbook, CellStyle nStyle, Font nFont) {
		nFont.setFontName("宋体");
		nFont.setFontHeightInPoints((short) 16);
		// 设置字体加粗
		nFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 横向居中
		nStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 纵向居中
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		nStyle.setFont(nFont);
		return nStyle;
	}

	// 标题样式
	public CellStyle Title(Workbook workbook, CellStyle nStyle, Font nFont) {
		nFont.setFontName("黑体");
		nFont.setFontHeightInPoints((short) 12);
		// 设置字体加粗
		nFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 横向居中
		nStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 纵向居中
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 表格线(上下左右的细线)
		nStyle.setBorderTop(CellStyle.BORDER_THIN);
		nStyle.setBorderLeft(CellStyle.BORDER_THIN);
		nStyle.setBorderRight(CellStyle.BORDER_THIN);
		nStyle.setBorderBottom(CellStyle.BORDER_THIN);

		nStyle.setFont(nFont);

		return nStyle;
	}

	// 文字样式
	public CellStyle Text(Workbook workbook, CellStyle nStyle, Font nFont) {
		nFont.setFontName("Times New Roman");
		nFont.setFontHeightInPoints((short) 10);
		// 横向居中
		nStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 纵向居中
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 表格线(上下左右的细线)
		nStyle.setBorderTop(CellStyle.BORDER_THIN);
		nStyle.setBorderLeft(CellStyle.BORDER_THIN);
		nStyle.setBorderRight(CellStyle.BORDER_THIN);
		nStyle.setBorderBottom(CellStyle.BORDER_THIN);

		nStyle.setFont(nFont);

		return nStyle;
	}
}
