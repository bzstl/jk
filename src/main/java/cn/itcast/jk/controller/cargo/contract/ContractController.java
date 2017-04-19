package cn.itcast.jk.controller.cargo.contract;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.ContractVo;
@Controller
public class ContractController extends BaseController {
	@Autowired
	private ContractService  contractService;
	
	
	@RequestMapping("/cargo/contract/list.action")
	public String List(Model model){
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);
		return "cargo/contract/jContractList.jsp";  
	}
	//转向新增页面
	@RequestMapping("/cargo/contract/tocreate.action")
	public String toCreate(Model model){
		
		return "cargo/contract/jContractCreate.jsp";  //转向页面
	}
	//新增保存
	
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract){
		contractService.insert(contract);
		return "redirect:/cargo/contract/list.action";//转向另一个controller
	}
	//转向修改页面
		@RequestMapping("/cargo/contract/toupdate.action")
		public String toUpdate(String id,Model model){
			Contract obj = contractService.get(id);
			model.addAttribute("obj", obj);
			
			
			return "cargo/contract/jContractUpdate.jsp";  //转向页面
		}
		//修改保存
		
		@RequestMapping("/cargo/contract/update.action")
		public String update(Contract contract){
			contractService.update(contract);
			return "redirect:/cargo/contract/list.action";//转向另一个controller
		}
		
		//删除一个
		@RequestMapping("/cargo/contract/deleteById.action")
		public String deleteById(String id){
			contractService.deleteById(id);
			return "redirect:/cargo/contract/list.action";
		}
		
		//删除多个
		@RequestMapping("/cargo/contract/delete.action")
		public String delete(@RequestParam("id")String[] ids){
			contractService.delete(ids);
			return "redirect:/cargo/contract/list.action";
		}
		
		
		//转向查看页面
		@RequestMapping("/cargo/contract/toview.action")
		public String toView(String id,Model model){
			ContractVo obj = contractService.view(id);
			model.addAttribute("obj", obj);
			
			
			return "cargo/contract/jContractView.jsp";  //转向页面
		}
		
		//批量上报
		@RequestMapping("/cargo/contract/submit.action")
		public String submit(@RequestParam("id")String[] ids){
			contractService.submit(ids);
			return "redirect:/cargo/contract/list.action";  //转向页面
		}
		
		//批量取消
		@RequestMapping("/cargo/contract/cancle.action")
		public String cancle(@RequestParam("id")String[] ids){
			contractService.cancle(ids);
			return "redirect:/cargo/contract/list.action";  //转向页面
		}
}
