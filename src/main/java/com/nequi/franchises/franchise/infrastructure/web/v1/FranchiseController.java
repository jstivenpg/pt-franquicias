package com.nequi.franchises.franchise.infrastructure.web.v1;

import com.nequi.franchises.franchise.application.ports.in.FranchiseService;
import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;
import com.nequi.franchises.shared.application.exceptions.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/franchises")
@RequiredArgsConstructor
@Tag(name = "franchises", description = "API to manage franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    @Operation(summary = "Find all franchises", tags = {"franchises", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Franchise list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<FranchiseDTO>> getAllFranchises(){
        return franchiseService.getAllFranchises();
    }

    @Operation(summary = "Find a franchise by id", tags = {"franchises", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Franchise get by id"),
            @ApiResponse(responseCode = "404", description = "Franchise not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping("/{franchiseId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<FranchiseDTO> getFranchiseById(@PathVariable Long franchiseId){
        return franchiseService.getFranchiseById(franchiseId);
    }

    @Operation(summary = "Create a franchise", tags = {"franchises", "POST"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Franchise created"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<FranchiseDTO> createFranchise(@RequestBody FranchiseDTO franchise){
        return franchiseService.createFranchise(franchise);
    }

    @Operation(summary = "Update a franchise", tags = {"franchises", "PUT"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Franchise created"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Franchise not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @PutMapping("/{franchiseId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<FranchiseDTO> updateFranchise(@PathVariable Long franchiseId, @RequestBody FranchiseDTO franchise){
        return franchiseService.updateFranchise(franchiseId, franchise);
    }

    @Operation(summary = "Delete a franchise", tags = {"franchises", "DELETE"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Franchise deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Franchise not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @DeleteMapping("/{franchiseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFranchise(@PathVariable Long franchiseId){
        franchiseService.deleteFranchise(franchiseId);
    }
}
