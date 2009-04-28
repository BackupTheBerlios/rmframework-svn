################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/CPP.cpp \
../src/JavaAgent.cpp 

OBJS += \
./src/CPP.o \
./src/JavaAgent.o 

CPP_DEPS += \
./src/CPP.d \
./src/JavaAgent.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/jvm/java-6-sun-1.6.0.07/include -I/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers -I/usr/lib/jvm/java-6-sun/include/linux -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


