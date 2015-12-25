import hiver
class hive_insert:
 	
	def _hql(self, hql):
    		client = hiver.connect("192.168.100.101", 10000)
    		client.execute(hql)
    		client.shutdown()

	def insert_job(self,table_name,filename):
		''' cannot insert single rows via hive, need to save to a temp file and bulk load that '''
    		self._hql('use Power')
		self._hql('DROP TABLE IF EXISTS %s' % table_name)
    		self._hql("""
				CREATE TABLE
				%s (
				jname string,
				jid string,
				jstart string,
				jend string,
				jres string
				)
				ROW FORMAT DELIMITED
				FIELDS TERMINATED BY '\t'
        		""" % (table_name))
    		self._hql("""
				LOAD DATA LOCAL INPATH '%s' INTO TABLE %s
        		""" % (filename, table_name))
	
	def insert_GPU_Perf(self,table_name,filename):
		''' cannot insert single rows via hive, need to save to a temp file and bulk load that '''
    		self._hql('use Power')
		self._hql('DROP TABLE IF EXISTS %s' % table_name)
    		self._hql("""
				CREATE TABLE
				%s (
				jid string,
				perf string,
				time_per_it string,
				total_time string
				)
				ROW FORMAT DELIMITED
				FIELDS TERMINATED BY '\t'
        		""" % (table_name))
    		self._hql("""
				LOAD DATA LOCAL INPATH '%s' INTO TABLE %s
        		""" % (filename, table_name))
	def insert_CPU_Perf(self,table_name,filename):
		''' cannot insert single rows via hive, need to save to a temp file and bulk load that '''
    		self._hql('use Power')
		self._hql('DROP TABLE IF EXISTS %s' % table_name)
    		self._hql("""
				CREATE TABLE
				%s (
				jid string,
				perf string,
				time_per_it string,
				total_time string
				)
				ROW FORMAT DELIMITED
				FIELDS TERMINATED BY '\t'
        		""" % (table_name))
    		self._hql("""
				LOAD DATA LOCAL INPATH '%s' INTO TABLE %s
        		""" % (filename, table_name))

	def insert_SYS_Perf(self,table_name,filename):
		''' cannot insert single rows via hive, need to save to a temp file and bulk load that '''
    		self._hql('use Power')
		self._hql('DROP TABLE IF EXISTS %s' % table_name)
    		self._hql("""
				CREATE TABLE
				%s (
				jid string,
				perf string,
				time_per_it string,
				total_time string
				)
				ROW FORMAT DELIMITED
				FIELDS TERMINATED BY '\t'
        		""" % (table_name))
    		self._hql("""
				LOAD DATA LOCAL INPATH '%s' INTO TABLE %s
        		""" % (filename, table_name))
				
	def insert_GPU_PWR(self,table_name,filename):
		''' cannot insert single rows via hive, need to save to a temp file and bulk load that '''
    		self._hql('use Power')
		self._hql('DROP TABLE IF EXISTS %s' % table_name)
    		self._hql("""
				CREATE TABLE
				%s (
				jid string,
				systimestamp string,
				power_draw string
				)
				ROW FORMAT DELIMITED
				FIELDS TERMINATED BY '\t'
        		""" % (table_name))
    		self._hql("""
				LOAD DATA LOCAL INPATH '%s' INTO TABLE %s
        		""" % (filename, table_name))
	
	def insert_node_PWR(self,table_name,filename):
		''' cannot insert single rows via hive, need to save to a temp file and bulk load that '''
    		self._hql('use Power')
		self._hql('DROP TABLE IF EXISTS %s' % table_name)
    		self._hql("""
				CREATE TABLE
				%s (
				jid string,
				nodeid string,
				systimestamp string,
				power_draw string
				)
				ROW FORMAT DELIMITED
				FIELDS TERMINATED BY '\t'
        		""" % (table_name))
    		self._hql("""
				LOAD DATA LOCAL INPATH '%s' INTO TABLE %s
        		""" % (filename, table_name))
				
hf=hive_insert()
hf.insert_job("job_info","/home/master_account/hive-0.9.0/bin/out_test_123.info")
hf.insert_GPU_Perf("gpu_perf","/home/master_account/hive-0.9.0/bin/out_test_123.GPU.txt")
hf.insert_CPU_Perf("cpu_perf","/home/master_account/hive-0.9.0/bin/out_test_123.CPU.txt")
hf.insert_SYS_Perf("sys_perf","/home/master_account/hive-0.9.0/bin/out_test_123.sys.txt")
hf.insert_GPU_PWR("gpu_pwr","/home/master_account/hive-0.9.0/bin/out_123_GPU.pwr.txt")
hf.insert_node_PWR("node_pwr","/home/master_account/hive-0.9.0/bin/out_123_node.pwr.txt")
