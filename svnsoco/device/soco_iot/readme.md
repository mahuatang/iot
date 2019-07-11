#1 IOT车联网核心服务

# app请求协议
1.APP登录请求
{
	"deviceNo": "0868120197538942",
	"msgType": "appLogin",
	"token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1MzQ0ODg5NjgsImFjY291bnQiOiI4Nl8xNzYwMjEwOTQ2OCJ9.NF3qwYB901ZFNlVB21snWf2sP-hBRLJPlxLOd_a8Y1vw2AWaXuYA-TicXUCQ47dH_58IsyqPG4AvD-fDO8WkoA"
}
2.APP请求车俩请求体检
{
	"msgType": "appVehicleCheckup",
	"deviceNo": "0868120197538942"
}
3.APP请求心跳
{
	"msgType": "appHeartbeat",
	"deviceNo": "0868120197538942"
}
切记所有请求转换成字节后追加 0x0d 0x0a 作为结束符