package com.stackroute.appointmentservice.service;

import com.stackroute.appointmentservice.exceptions.AppointmentIdNotFound;
import com.stackroute.appointmentservice.exceptions.EmployeeIdNotFound;
import com.stackroute.appointmentservice.exceptions.ServiceNotFound;
import com.stackroute.appointmentservice.model.Slots;
import com.stackroute.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Slots createAppointment(Slots slots) throws ParseException {
        return appointmentRepository.insert(slots);
    }

    @Override
    public String deleteAppointment(String appointmentId) throws AppointmentIdNotFound {
        return null;
    }

    @Override
    public String deleteAppointment(int appointmentId) throws AppointmentIdNotFound{
        if(appointmentRepository.findById(appointmentId).isPresent()){
            appointmentRepository.deleteById(appointmentId);
            return "Appointment Details Deleted";}
        else {
            throw new AppointmentIdNotFound();}
    }
    @Override
    public String updateAppointment(Slots slots) throws AppointmentIdNotFound {
        if(appointmentRepository.findById(slots.getAppointmentId()).isPresent()){
            appointmentRepository.save(slots);
            return "Appointment Details Updated";}
        else {
            throw new AppointmentIdNotFound();}
    }
    @Override
    public List<Slots> getAllAppointments(){
        return appointmentRepository.findAll();
    }
    @Override
    public List<Slots> getAppointmentsByServiceId(String serviceId) throws ServiceNotFound {
        if(!appointmentRepository.getAppointmentsByServiceId(serviceId).isEmpty()){
            return appointmentRepository.getAppointmentsByServiceId(serviceId);
        }else {throw new ServiceNotFound();}
    }

    @Override
    public List<Slots> getByServiceIdAndDate(String serviceId, String date) throws ServiceNotFound {
        List<Slots> f = new ArrayList<>();
        if (!appointmentRepository.getAppointmentsByServiceId(serviceId).isEmpty()) {
            List<Slots> list = appointmentRepository.getAppointmentsByServiceId(serviceId);
            for (Slots li : list) {
                Date d = li.getStartTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startDate = dateFormat.format(d);
                if (startDate.startsWith(date)) {
                    f.add(li);
                }
            }
            return f;
        }
         throw new ServiceNotFound();
    }

    @Override
    public List<Slots> getAppointmentsByEmployeeId(String employeeId)  {
//        if(!appointmentRepository.getAppointmentsByEmployeeId(employeeId).isEmpty()){
            return appointmentRepository.getAppointmentsByEmployeeId(employeeId);}
//        else {throw new EmployeeIdNotFound();}

    @Override
    public List<Slots> getAppointmentsByEmployeeAndDate(String employeeId, String date) throws EmployeeIdNotFound{
        List<Slots> f=new ArrayList<>();
        if(!appointmentRepository.getAppointmentsByEmployeeId(employeeId).isEmpty()){
            List<Slots> list= appointmentRepository.getAppointmentsByEmployeeId(employeeId);
            for(Slots li : list){
                Date d=  li.getStartTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startDate = dateFormat.format(d);
                if(startDate.startsWith(date)){
                    f.add(li);
                }
            }
            return f;
        }else {
            return new ArrayList<>();
        }
    }

}