###change filenames to filename = "simple%d%d.csv"
import sys
import datetime
import dateutil.parser
import calendar
job_id=0
sys.stdout = open('out_test_123.info', "w")
y=""
with open('test_123.info') as f:
	for line in f:
		line = line.strip()
		x = line.split(":")
		if(len(x)==2):
			y=y+str(x[1])+'\t'
			if((x[0].strip())=='ID'):
				job_id=x[1]
		if(len(x)>2):
			y=y+str(x[1]+":"+x[2]+":"+x[3])+'\t'
	print y
			

sys.stdout = open('out_123_GPU.pwr.txt', "w")
y=""
with open('test_123_GPU.pwr.txt') as f:
	i = 0
	
	y=y+str(job_id)+'\t'
	for line in f:
		
		i = i + 1
		line = line.strip()
		x = line.split(":")
		if(len(x)==2 and (x[0].strip())=='Power Draw'):
			y=y+str(x[1])+'\t'
		if(len(x) == 4):
			x[1]=x[1]+":"+x[2]+":"+x[3]
			c = dateutil.parser.parse(x[1])
			x[1] = calendar.timegm(c.timetuple())
			y=y+str(x[1])+'\t'
		if(i % 16 == 0 or i==0):
			print y
			y=""
			y=y+str(job_id)+'\t'
						
sys.stdout = open('out_test_123.perf.txt', "w")
i = 1
with open('test_123.perf.txt') as f:
	for line in f:
		i = i+1
		if i > 22 and i < 26:
			#print(line)
			temp = line.split("=")
			perf = temp[1].split(".")
			cpu = temp[2].split(".")
			syst = temp[3].split(".")
			if(i==23):
				sys.stdout = open('out_test_123.GPU.txt', "w")
			if(i==24):
				sys.stdout = open('out_test_123.CPU.txt', "w")
					
			if(i==25):
				sys.stdout = open('out_test_123.sys.txt', "w")
			
			print(str(job_id+"\t"+perf[0].strip()+"."+perf[1].split(" ")[0]+"\t"+cpu[0].strip()+"."+cpu[1].split(" ")[0]+"\t"+syst[0].strip()+"."+syst[1].split(" ")[0]))
		
sys.stdout = open('out_123_node.pwr.txt', "w")
with open('test_123_node.pwr.txt') as f:
	for line in f:
		x = line.split(" ")
		print(job_id+"\t"+x[0].strip()+"\t"+x[1].strip()+"\t"+x[2].strip())

