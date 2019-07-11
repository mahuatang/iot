//地图容器
var chart = echarts.init(document.getElementById('main'));
var geo={};
//34个省、市、自治区的名字拼音映射数组
var provinces = {
    //23个省
    "台湾": "taiwan",
    "河北": "hebei",
    "山西": "shanxi",
    "辽宁": "liaoning",
    "吉林": "jilin",
    "黑龙江": "heilongjiang",
    "江苏": "jiangsu",
    "浙江": "zhejiang",
    "安徽": "anhui",
    "福建": "fujian",
    "江西": "jiangxi",
    "山东": "shandong",
    "河南": "henan",
    "湖北": "hubei",
    "湖南": "hunan",
    "广东": "guangdong",
    "海南": "hainan",
    "四川": "sichuan",
    "贵州": "guizhou",
    "云南": "yunnan",
    "陕西": "shanxi1",
    "甘肃": "gansu",
    "青海": "qinghai",
    //5个自治区
    "新疆": "xinjiang",
    "广西": "guangxi",
    "内蒙古": "neimenggu",
    "宁夏": "ningxia",
    "西藏": "xizang",
    //4个直辖市
    "北京": "beijing",
    "天津": "tianjin",
    "上海": "shanghai",
    "重庆": "chongqing",
    //2个特别行政区
    "香港": "xianggang",
    "澳门": "aomen"
};

//直辖市和特别行政区-只有二级地图，没有三级地图
var special = ["北京","天津","上海","重庆","香港","澳门"];
var mapdata = [];
var postParams={
				areaType:2,
				latitude:22.198951,
				longitude:113.54909,
				url:"map/china.json",
				paramName:'china'
			};
//初始化全国各省数据
geo.initAreaInfo=function(postParams){
	$.post({
		url:"trailDevice/searchAreaInfo",
		data:JSON.stringify({'areaType':postParams.areaType,'latitude':postParams.latitude,'longitude':postParams.longitude}),
	    headers: {'Content-Type': 'application/json'},
		dataType:"json",
		success:function(data){
			geo.initChinaMap(data,postParams);
		}
	})
}
geo.initAreaInfo(postParams);

geo.initChinaMap=function(myData,postParams){
	//绘制全国地图
	$.getJSON({
	    url:postParams.url,
	    dataType: "json",
	    success:function(data){
		d = [];
		for( var i=0;i<data.features.length;i++ ){
			var value=0;
			var areaName=data.features[i].properties.name;
			if(myData.resultCode=="200"){
				if(myData.data.areaInfoList.length>0){
					var areaInfoList=myData.data.areaInfoList;
					for(var j=0;j<areaInfoList.length;j++){
						if(areaInfoList[j].areaName.indexOf(areaName)>-1){
							value=areaInfoList[j].size;
							break;
						}
					}
				}
			}
			d.push({
				name:areaName,
				value:value,
				geo:data.features[i].properties.cp
			})
		}
		mapdata = d;
		//注册地图
		echarts.registerMap(postParams.paramName, data);
		//绘制地图
		renderMap(postParams.paramName,d);
	    }
	});
}
//地图点击事件
chart.on('click', function (params) {
	// console.log( params );
	// console.log( provinces );
	if( params.name in provinces ){
		//如果点击的是34个省、市、自治区，绘制选中地区的二级地图
//		$.getJSON({
//				url:'map/province/'+ provinces[params.name] +'.json',
//			    dataType: "json",
//			    success:function(data){
//				echarts.registerMap( params.name, data);
//				var d = [];
//				for( var i=0;i<data.features.length;i++ ){
//					d.push({
//						name:data.features[i].properties.name,
//						value:100
//					})
//				}
//				renderMap(params.name,d);
//			}
//		});
//		alert(params.name);
//		alert(provinces[params.name]);
//		console.log(params)
//		console.log(params.data.geo);
		var latitude=22.198951;
		var longitude=113.54909;
		var areaType=3;
//		console.log(params.data.geo+","+params.name);
//		console.log(special.indexOf( params.name ));
		if( special.indexOf( params.name ) >-1  ){
			areaType=4;
		}
		
		if(params.data.geo!=null && params.data.geo.length==2){
			latitude=params.data.geo[1];
			longitude=params.data.geo[0];
		}
		var postParams={
				areaType:areaType,
				latitude:latitude,
				longitude:longitude,
				url:'map/province/'+ provinces[params.name] +'.json',
				paramName:params.name
			};
		geo.initAreaInfo(postParams);
		
	}else if( params.seriesName in provinces ){
		//如果是【直辖市/特别行政区】只有二级下钻
		if(  special.indexOf( params.seriesName ) >=0  ){
//			renderMap('china',mapdata);
			var postParams={
					areaType:2,
					latitude:22.198951,
					longitude:113.54909,
					url:"map/china.json",
					paramName:'china'
				};
			geo.initAreaInfo(postParams);
		}else{
			//显示县级地图
//			$.getJSON({
//					url:'map/city/'+ cityMap[params.name] +'.json', 
//				    dataType: "json",
//				    success:function(data){
//					echarts.registerMap( params.name, data);
//					var d = [];
//					for( var i=0;i<data.features.length;i++ ){
//						d.push({
//							name:data.features[i].properties.name,
//							value:100
//						})
//					}
//					renderMap(params.name,d);
//				}
//			});	
			var latitude=22.198951;
			var longitude=113.54909;
			var areaType=4;
			
			if(params.data.geo!=null && params.data.geo.length==2){
				latitude=params.data.geo[1];
				longitude=params.data.geo[0];
			}
			var postParams={
					areaType:areaType,
					latitude:latitude,
					longitude:longitude,
					url:'map/city/'+ cityMap[params.name] +'.json',
					paramName:params.name
				};
			geo.initAreaInfo(postParams);
		}	
	}else{
//		renderMap('china',mapdata);
		var postParams={
				areaType:2,
				latitude:22.198951,
				longitude:113.54909,
				url:"map/china.json",
				paramName:'china'
			};
		geo.initAreaInfo(postParams);
	}
});

//初始化绘制全国地图配置
var option = {
	backgroundColor: '#000',
    title : {
        text: 'SOCO车俩时时全国分布图',
        subtext: '支持到地区',
        link:'http://www.supersoco.com',
        left: 'center',
        textStyle:{
            color: '#fff',
            fontSize:16,
            fontWeight:'normal',
            fontFamily:"Microsoft YaHei"
        },
        subtextStyle:{
        	color: '#ccc',
            fontSize:13,
            fontWeight:'normal',
            fontFamily:"Microsoft YaHei"
        }
    },
    tooltip: {
        trigger: 'item',
        formatter: function(result){
//        	console.log(result);
        	return result.name+'<br />数据:'+result.value;
        }
    },
    toolbox: {
        show: true,
        orient: 'vertical',
        left: 'right',
        top: 'center',
        feature: {
            dataView: {readOnly: false},
            restore: {},
            saveAsImage: {}
        },
        iconStyle:{
        	normal:{
        		color:'#fff'
        	}
        }
    },
    animationDuration:1000,
	animationEasing:'cubicOut',
	animationDurationUpdate:1000
     
};
function renderMap(map,data){
//	console.log("renderMap");
//	console.log( data );
	option.title.subtext = map;
    option.series = [ 
		{
            name: map,
            type: 'map',
            mapType: map,
            roam: false,
            nameMap:{
			    'china':'中国'
			},
            label: {
	            normal:{
					show:true,
					textStyle:{
						color:'#999',
						fontSize:13
					}  
	            },
	            emphasis: {
	                show: true,
	                textStyle:{
						color:'#fff',
						fontSize:13
					}
	            }
	        },
	        itemStyle: {
	            normal: {
	                areaColor: '#323c48',
	                borderColor: 'dodgerblue',
	                label: {   // 地图上的显示                         
                        show: true,
                        formatter:function(params){
//                           console.log(JSON.stringify(params));
                            return params.name+"\r\n"+params.value; 
                        },
                    }
	            },
	            emphasis: {
	                areaColor: 'darkorange'
	            }
	        },
            data:data
        }	
    ];
    //渲染地图
    chart.setOption(option);
    function randomData() {
        return Math.round(Math.random()*1000);
    }
}