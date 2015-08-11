package org.cakepowered.api.command;

public class CommandResult {

	public static final CommandResult EMPTY = new CommandResult(0, 0, 0, 0, 0);

	private int successCount;
	private int affectedBlocks;
	private int affectedEntities;
	private int affectedItems;
	private int queryResult;

	public CommandResult(int successCount, int affectedBlocks, int affectedEntities, int affectedItems, int queryResult){
		this.successCount = successCount;
		this.affectedBlocks = affectedBlocks;
		this.affectedEntities = affectedEntities;
		this.affectedItems = affectedItems;
		this.queryResult = queryResult;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public int getAffectedBlocks() {
		return affectedBlocks;
	}

	public void setAffectedBlocks(int affectedBlocks) {
		this.affectedBlocks = affectedBlocks;
	}

	public int getAffectedEntities() {
		return affectedEntities;
	}

	public void setAffectedEntities(int affectedEntities) {
		this.affectedEntities = affectedEntities;
	}

	public int getAffectedItems() {
		return affectedItems;
	}

	public void setAffectedItems(int affectedItems) {
		this.affectedItems = affectedItems;
	}

	public int getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(int queryResult) {
		this.queryResult = queryResult;
	}
	
	
}
