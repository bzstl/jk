package cn.itcast.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ExtCProduct;
import cn.itcast.jk.service.ExtCProductService;
import cn.itcast.jk.service.FactoryService;


@Controller
public class ExtCProductController extends BaseController {
	@Autowired
	private ExtCProductService extCProductService;
    @Autowired
    private FactoryService factoryService;
	
	//转向新增页面  
    @RequestMapping("/cargo/extcproduct/tocreate.action")  
    public String tocreate(String contractProductId,Model model){  
        //传递货物Id  
        model.addAttribute("contractProductId", contractProductId); 
        
        //获取厂家列表
        model.addAttribute("factoryList", factoryService.getFactoryList());
        
      //获列表
        Map paraMap=new HashMap();
        paraMap.put("contractProductId", contractProductId);
        model.addAttribute("dataList", extCProductService.find(paraMap));
        
        //准备分类
        model.addAttribute("ctypeList", extCProductService.getCtypeList());
        
        //获取合同ID
       // model.addAttribute("contractId", extCProductService.getContractIdBycontractProductId(contractProductId));
     
        return "/cargo/contract/jExtCProductCreate.jsp";//货物的新增页面  
    }  
    
    
    //新增  
    @RequestMapping("/cargo/extcproduct/insert.action")  
    public String insert(ExtCProduct extCProduct,Model model){  
    	
    	extCProductService.insert(extCProduct);  
          
        model.addAttribute("contractProductId", extCProduct.getContractProductId());
        
        return "redirect:/cargo/extcproduct/tocreate.action";  
    }
    
    //跳向修改页面
    @RequestMapping("/cargo/extcproduct/toupdate.action")  
    public String toUpdate(String id,Model model){  
         
    	
        model.addAttribute("obj", extCProductService.get(id));
      //获取厂家列表
        model.addAttribute("factoryList", factoryService.getFactoryList());
        
        //准备分类
        model.addAttribute("ctypeList", extCProductService.getCtypeList());
        
        
        return "/cargo/contract/jExtCProductUpdate.jsp";  
    }
    
    //修改页面
    
    @RequestMapping("/cargo/extcproduct/update.action")  
    public String update(ExtCProduct extCProduct,Model model){  
         
    	extCProductService.update(extCProduct);
 
    	model.addAttribute("contractProductId", extCProduct.getContractProductId());
        
        return "redirect:/cargo/extcproduct/tocreate.action";  
    }
    
    //删除
    
    @RequestMapping("/cargo/extcproduct/deletebyid.action")  
    public String deleteById(String id,String contractProductId,Model model){  
         
    	extCProductService.deleteById(id);
 
    	model.addAttribute("contractProductId", contractProductId);
        
        return "redirect:/cargo/extcproduct/tocreate.action";  
    }
    
    @RequestMapping("/cargo/extcproduct/returnc.action")  
    public String returnc(Model model,String contractProductId){  
         
   
 
    	model.addAttribute("contractId",extCProductService.getContractIdBycontractProductId(contractProductId) );
        
        return "redirect:/cargo/contractproduct/tocreate.action";  
    }
    
    
}
