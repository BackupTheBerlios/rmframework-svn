/*
 * Copyright (c) 2008, Heiko Kundlacz
 * Licensed under the Apache License Version 2. 
 * For full terms see the file apache-license-2.0.txt
 */

package net.form105.rm.base.command;

import java.util.List;

import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.service.ResultStatus;
import net.form105.rm.server.i18n.BaseI18NMessage;

import org.apache.log4j.Logger;

/**
 * 
 * @author hk
 */
public class CommandHandler<T> extends AbstractCommandHandler<T> {

    public static Logger logger = Logger.getLogger(CommandHandler.class);

    @Override
    public void execute(List<ICommand> commands) {

        try {

            for (ICommand command : commands) {
                logger.info("Executing command: " + command.getOid());
                command.execute();
            }
            getResult().setStatus(ResultStatus.SUCCESS);
        } catch (Exception ex) {
            BaseI18NMessage message = new BaseI18NMessage();
            RMException rmEx = new RMException(message, "exception.command.default", new String[] {}, ex);
            getResult().setStatus(ResultStatus.FAIL);
            getResult().setException(rmEx);
            throw rmEx;
        }

    }

}
