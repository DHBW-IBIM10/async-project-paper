CommandLine cmdLine = new CommandLine("ls");
cmdLine.addArgument("-lh");
cmdLine.addArgument("/usr");

DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler(){
	public void onProcessComplete(int exitValue){
		logger.info("Process terminated normally");
	}
			
	public void onProcessFailed(ExecuteException e){
		logger.info("Process failed");
	}
};
		
StdoutStream stdout = new StdoutStream();

ExecuteWatchdog watchdog = new ExecuteWatchdog(60*1000); //timeout after 6 seconds
DefaultExecutor executor = new DefaultExecutor();
executor.setStreamHandler(new PumpStreamHandler(stdout, null, null));
executor.setExitValue(0);
executor.setWatchdog(watchdog);
try {
	executor.execute(cmdLine, resultHandler);
} catch (IOException e1) {
	e1.printStackTrace();
}