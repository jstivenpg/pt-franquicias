package com.nequi.franchises.branch.infrastructure.web.v1;

import com.nequi.franchises.branch.application.ports.in.BranchService;
import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;
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
@RequestMapping("/api/v1/branchs")
@RequiredArgsConstructor
@Tag(name = "branchs", description = "API to manage branchs")
public class BranchController {

    private final BranchService branchService;

    @Operation(summary = "Find all branchs", tags = {"branchs", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Branch list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<BranchDTO>> getAllBranchs(){
        return branchService.getAllBranchs();
    }

    @Operation(summary = "Find a branch by id", tags = {"branchs", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Branch get by id"),
            @ApiResponse(responseCode = "404", description = "Branch not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping("/{branchId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<BranchDTO> getBranchById(@PathVariable Long branchId){
        return branchService.getBranchById(branchId);
    }

    @Operation(summary = "Create a branch", tags = {"branchs", "POST"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Branch created"),
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
    public GeneralResponse<BranchDTO> createBranch(@RequestBody BranchDTO branch){
        return branchService.createBranch(branch);
    }

    @Operation(summary = "Update a branch", tags = {"branchs", "PUT"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Branch created"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Branch not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @PutMapping("/{branchId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<BranchDTO> updateBranch(@PathVariable Long branchId, @RequestBody BranchDTO branch){
        return branchService.updateBranch(branchId, branch);
    }

    @Operation(summary = "Delete a branch", tags = {"branchs", "DELETE"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Branch deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Branch not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @DeleteMapping("/{branchId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBranch(@PathVariable Long branchId){
        branchService.deleteBranch(branchId);
    }
}
