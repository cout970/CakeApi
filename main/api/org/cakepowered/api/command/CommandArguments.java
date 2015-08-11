package org.cakepowered.api.command;

import java.util.Collection;
import java.util.Collections;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class CommandArguments {
	
	private final Multimap<String, Object> parsedArgs;
	
	public CommandArguments() {
        parsedArgs = ArrayListMultimap.create();
    }
	
	public void putArg(String key, Object value) {
        parsedArgs.put(key, value);
    }
	
	public boolean hasAny(String key) {
        return parsedArgs.containsKey(key);
    }
	
	public void checkPermission(CommandSender commander, String permission) throws CommandException {
        if (!commander.hasPermission(permission)) {
            throw new CommandException("You do not have permission to use this command!");
        }
    }
	
	@SuppressWarnings("unchecked")
    public <T> Collection<T> getAll(String key) {
        return Collections.unmodifiableCollection((Collection<T>) this.parsedArgs.get(key));
    }
	
	@SuppressWarnings("unchecked")
    public <T> Optional<T> getOne(String key) {
        Collection<Object> values = this.parsedArgs.get(key);
        if (values.size() != 1) {
            return Optional.absent();
        } else {
            return Optional.fromNullable((T) values.iterator().next());
        }
    }
}
