var cmu = [
            {
               header: "ID",
               dataIndex: 'help_category_id',
               dataType:'number'
            },
            {
               header: "Parent ID",
               dataIndex: 'parent_category_id',
               dataType:'number',
               width:50
            },
            {
               header: "Name",
               dataIndex: 'name',
               dataType:'string',
               width:200
            }];	
    
    window.addEvent("domready", function(){
	                
	    datagrid = new omniGrid('mygrid', {
	        columnModel: cmu,
	        buttons : [
	          {name: 'Add', bclass: 'add', onclick : gridButtonClick},
	          {name: 'Delete', bclass: 'delete', onclick : gridButtonClick},
	          {separator: true},
	          {name: 'Duplicate', bclass: 'duplicate', onclick : gridButtonClick}
	        ],
	        url:"data.php",
	        perPageOptions: [10,20,50,100,200],
	        perPage:10,
	        page:1,
	        pagination:true,
	        serverSort:true,
	        showHeader: true,
	        alternaterows: true,
	        showHeader:true,
	        sortHeader:false,
	        resizeColumns:true,
	        multipleSelection:true,
	        
	        // uncomment this if you want accordion behavior for every row
	        /*
	        accordion:true,
	        accordionRenderer:accordionFunction,
	        autoSectionToggle:false,
	        */
				
	        width:600,
	        height: 400
	    });
	    
	    datagrid.addEvent('click', onGridSelect);
	    		
     });
