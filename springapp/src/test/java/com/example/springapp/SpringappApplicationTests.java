package com.example.springapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

import com.example.springapp.controller.MedicineController;
import com.example.springapp.model.Medicine;
import com.example.springapp.service.MedicineService;

@ExtendWith(MockitoExtension.class)
public class SpringappApplicationTests {

    @Mock
    private MedicineService medicineService;

    @InjectMocks
    private MedicineController medicineController;

    @Test
    public void testAddMedicine() {
        Medicine medicineToAdd = new Medicine(1, "Medicine 1", 10.0f, 5, "Description 1");

        when(medicineService.addMedicine(medicineToAdd)).thenReturn(true);

        boolean response = medicineController.addMedicine(medicineToAdd);

        assertThat(response).isTrue();

        verify(medicineService, times(1)).addMedicine(medicineToAdd);
    }

    @Test
    public void testGetMedicine() {
        Medicine medicine = new Medicine(1, "Medicine 1", 10.0f, 5, "Description 1");

        when(medicineService.getMedicine(1)).thenReturn(medicine);

        Medicine response = medicineController.getMedicine(1);

        assertThat(response).isEqualTo(medicine);

        verify(medicineService, times(1)).getMedicine(1);
    }

    @Test
    public void testGetAllMedicines() {
        List<Medicine> mockMedicines = new ArrayList<>();
        mockMedicines.add(new Medicine(1, "Medicine 1", 10.0f, 5, "Description 1"));
        mockMedicines.add(new Medicine(2, "Medicine 2", 15.0f, 3, "Description 2"));

        when(medicineService.getAllMedicines()).thenReturn(mockMedicines);

        List<Medicine> response = medicineController.getAllMedicines();

        assertThat(response).isEqualTo(mockMedicines);

        verify(medicineService, times(1)).getAllMedicines();
    }

    @Test
    public void testUpdateMedicine() {
        Medicine medicineToUpdate = new Medicine(1, "Updated Medicine", 20.0f, 10, "Updated Description");

        when(medicineService.updateMedicine(1, medicineToUpdate)).thenReturn(medicineToUpdate);

        Medicine response = medicineController.updateMedicine(1, medicineToUpdate);

        assertThat(response).isEqualTo(medicineToUpdate);

        verify(medicineService, times(1)).updateMedicine(1, medicineToUpdate);
    }

    @Test
    public void testDeleteMedicine() {
        when(medicineService.deleteMedicine(1)).thenReturn(true);

        boolean response = medicineController.deleteMedicine(1);

        assertThat(response).isTrue();

        verify(medicineService, times(1)).deleteMedicine(1);
    }

    @Test 
    public void testcontrollerfolder() { 
        String directoryPath = "src/main/java/com/example/springapp/controller"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testcontrollerfile() { 
        String filePath = "src/main/java/com/example/springapp/controller/MedicineController.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testModelFolder() { 
        String directoryPath = "src/main/java/com/example/springapp/model"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testModelFile() { 
        String filePath = "src/main/java/com/example/springapp/model/Medicine.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }


	@Test 
    public void testServiceFolder() { 
        String directoryPath = "src/main/java/com/example/springapp/service"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testServieFile() { 
        String filePath = "src/main/java/com/example/springapp/service/MedicineService.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }





}
