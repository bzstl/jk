package cn.itcast.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.FactoryService;

@Controller
public class ContractProductController {
    @Autowired  
    ContractProductService contractProductService;   
    @Autowired
    FactoryService factoryService;
    
    //转向新增页面  
    @RequestMapping("/cargo/contractproduct/tocreate.action")  
    public String tocreate(String contractId,Model model){  
        //传递购销合同Id  
        model.addAttribute("contractId", contractId); 
        
        //获取厂家列表
        model.addAttribute("factoryList", factoryService.getFactoryList());
        
      //获取合同中的货物列表
        Map paraMap=new HashMap();
        paraMap.put("contractId", contractId);
        
        model.addAttribute("dataList", contractProductService.find(paraMap));
     
        return "/cargo/contract/jContractProductCreate.jsp";//货物的新增页面  
    }  
      
    //新增  
    @RequestMapping("/cargo/contractproduct/insert.action")  
    public String insert(ContractProduct contractProduct,Model model){  
    	
        contractProductService.insert(contractProduct);  
          
        model.addAttribute("contractId", contractProduct.getContractId()); 
        return "redirect:/cargo/contractproduct/tocreate.action";  
    }  
    
    //转向修改页面
    @RequestMapping("/cargo/contractproduct/toupdate.action")
    public String toUpdate(String id,Model model){
    	//获取欲更新记录
    	ContractProduct contractProduct = contractProductService.get(id);
    	model.addAttribute("obj", contractProduct);
    	
    	//获取厂家列表
        model.addAttribute("factoryList", factoryService.getFactoryList());
    	
    	return "/cargo/contract/jContractProductUpdate.jsp";
    }
    
    //保存修改
    @RequestMapping("/cargo/contractproduct/update.action")
    public String update(ContractProduct contractProduct,Model model){
    	contractProductService.update(contractProduct);
    	
    	
    	model.addAttribute("contractId", contractProduct.getContractId());
    	return "redirect:/cargo/contractproduct/tocreate.action";
    }
    
    //删除一个
    @RequestMapping("/cargo/contractproduct/deletebyid.action")
    public String toDeleteById(String id,String contractId,Model model){
    	contractProductService.deleteById(id);
    	model.addAttribute("contractId", contractId);
    	return "redirect:/cargo/contractproduct/tocreate.action";
    }
    
}
