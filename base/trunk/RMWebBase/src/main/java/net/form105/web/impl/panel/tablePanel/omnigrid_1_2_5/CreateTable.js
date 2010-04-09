function onGridSelect(evt)
    {
         var str = 'row: '+evt.row+' indices: '+evt.indices;
         str += ' id: '+evt.target.getDataByRow(evt.row).id;
         
         alert( str );
    }
	
    function gridButtonClick(button, grid)
    {
         alert(button);
    }
	
    
    
    window.addEvent("domready", function(){
	                
	    datagrid = new omniGrid('mygrid', {
	        columnModel: cmu,
	        buttons : [
	          {name: 'Add', bclass: 'add', onclick : gridButtonClick},
	          {name: 'Delete', bclass: 'delete', onclick : gridButtonClick},
	          {separator: true},
	          {name: 'Duplicate', bclass: 'duplicate', onclick : gridButtonClick}
	        ],
	        url:"www.omnisdata.com/omnigrid/data.php",
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
				
	        width:500,
	        height: 400
	    });
	    
	    datagrid.addEvent('click', onGridSelect);
	    		
     });
