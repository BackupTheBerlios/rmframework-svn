################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/CPP.cpp 

OBJS += \
./src/CPP.o 

CPP_DEPS += \
./src/CPP.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -DFMPLUGIN_DEBUG=1 -I/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers -O0 -g3 -Wall -isysroot /Developer/SDKs/MacOSX10.4u.sdk -include "/Users/heikok/development/fileMakerPlugin/24U FM Template 2.2/Projects/XCode/../../Support/FMTemplate/FMTemplatePrefix.h" -v -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -F/tmp/lib -F/System/Library/Frameworks/Carbon.framework -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


