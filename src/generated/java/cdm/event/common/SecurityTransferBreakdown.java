package cdm.event.common;

import cdm.base.staticdata.asset.common.Security;
import cdm.event.common.meta.SecurityTransferBreakdownMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityTransferBreakdown extends RosettaModelObject {
	SecurityTransferBreakdown build();
	SecurityTransferBreakdown.SecurityTransferBreakdownBuilder toBuilder();
	
	/**
	 */
	BigDecimal getQuantity();
	/**
	 * The securities that are being transfered
	 */
	List<? extends Security> getSecurity();
	/**
	 * The transferee and transferor party information.
	 */
	TransferorTransferee getTransferorTransferee();
	final static SecurityTransferBreakdownMeta metaData = new SecurityTransferBreakdownMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityTransferBreakdown> metaData() {
		return metaData;
	} 
			
	static SecurityTransferBreakdown.SecurityTransferBreakdownBuilder builder() {
		return new SecurityTransferBreakdown.SecurityTransferBreakdownBuilderImpl();
	}
	
	default Class<? extends SecurityTransferBreakdown> getType() {
		return SecurityTransferBreakdown.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		
		processRosetta(path.newSubPath("security"), processor, Security.class, getSecurity());
		processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.class, getTransferorTransferee());
	}
	
	
	interface SecurityTransferBreakdownBuilder extends SecurityTransferBreakdown, RosettaModelObjectBuilder {
		Security.SecurityBuilder getOrCreateSecurity(int _index);
		List<? extends Security.SecurityBuilder> getSecurity();
		TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee();
		TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee();
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder setQuantity(BigDecimal quantity);
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder addSecurity(Security security);
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder addSecurity(Security security, int _idx);
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder addSecurity(List<? extends Security> security);
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder setSecurity(List<? extends Security> security);
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder setTransferorTransferee(TransferorTransferee transferorTransferee);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			
			processRosetta(path.newSubPath("security"), processor, Security.SecurityBuilder.class, getSecurity());
			processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.TransferorTransfereeBuilder.class, getTransferorTransferee());
		}
		
	}
	
	//SecurityTransferBreakdown.SecurityTransferBreakdownImpl
	class SecurityTransferBreakdownImpl implements SecurityTransferBreakdown {
		private final BigDecimal quantity;
		private final List<? extends Security> security;
		private final TransferorTransferee transferorTransferee;
		
		protected SecurityTransferBreakdownImpl(SecurityTransferBreakdown.SecurityTransferBreakdownBuilder builder) {
			this.quantity = builder.getQuantity();
			this.security = ofNullable(builder.getSecurity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transferorTransferee = ofNullable(builder.getTransferorTransferee()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public List<? extends Security> getSecurity() {
			return security;
		}
		
		@Override
		public TransferorTransferee getTransferorTransferee() {
			return transferorTransferee;
		}
		
		@Override
		public SecurityTransferBreakdown build() {
			return this;
		}
		
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder toBuilder() {
			SecurityTransferBreakdown.SecurityTransferBreakdownBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityTransferBreakdown.SecurityTransferBreakdownBuilder builder) {
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
			ofNullable(getTransferorTransferee()).ifPresent(builder::setTransferorTransferee);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityTransferBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(security, _that.getSecurity())) return false;
			if (!Objects.equals(transferorTransferee, _that.getTransferorTransferee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityTransferBreakdown {" +
				"quantity=" + this.quantity + ", " +
				"security=" + this.security + ", " +
				"transferorTransferee=" + this.transferorTransferee +
			'}';
		}
	}
	
	//SecurityTransferBreakdown.SecurityTransferBreakdownBuilderImpl
	class SecurityTransferBreakdownBuilderImpl implements SecurityTransferBreakdown.SecurityTransferBreakdownBuilder {
	
		protected BigDecimal quantity;
		protected List<Security.SecurityBuilder> security = new ArrayList<>();
		protected TransferorTransferee.TransferorTransfereeBuilder transferorTransferee;
	
		public SecurityTransferBreakdownBuilderImpl() {
		}
	
		@Override
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public List<? extends Security.SecurityBuilder> getSecurity() {
			return security;
		}
		
		public Security.SecurityBuilder getOrCreateSecurity(int _index) {
		
			if (security==null) {
				this.security = new ArrayList<>();
			}
			Security.SecurityBuilder result;
			return getIndex(security, _index, () -> {
						Security.SecurityBuilder newSecurity = Security.builder();
						return newSecurity;
					});
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee() {
			return transferorTransferee;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee() {
			TransferorTransferee.TransferorTransfereeBuilder result;
			if (transferorTransferee!=null) {
				result = transferorTransferee;
			}
			else {
				result = transferorTransferee = TransferorTransferee.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder addSecurity(Security security) {
			if (security!=null) this.security.add(security.toBuilder());
			return this;
		}
		
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder addSecurity(Security security, int _idx) {
			getIndex(this.security, _idx, () -> security.toBuilder());
			return this;
		}
		@Override 
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder addSecurity(List<? extends Security> securitys) {
			if (securitys != null) {
				for (Security toAdd : securitys) {
					this.security.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder setSecurity(List<? extends Security> securitys) {
			if (securitys == null)  {
				this.security = new ArrayList<>();
			}
			else {
				this.security = securitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder setTransferorTransferee(TransferorTransferee transferorTransferee) {
			this.transferorTransferee = transferorTransferee==null?null:transferorTransferee.toBuilder();
			return this;
		}
		
		@Override
		public SecurityTransferBreakdown build() {
			return new SecurityTransferBreakdown.SecurityTransferBreakdownImpl(this);
		}
		
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder prune() {
			security = security.stream().filter(b->b!=null).<Security.SecurityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (transferorTransferee!=null && !transferorTransferee.prune().hasData()) transferorTransferee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantity()!=null) return true;
			if (getSecurity()!=null && getSecurity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransferorTransferee()!=null && getTransferorTransferee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityTransferBreakdown.SecurityTransferBreakdownBuilder o = (SecurityTransferBreakdown.SecurityTransferBreakdownBuilder) other;
			
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::getOrCreateSecurity);
			merger.mergeRosetta(getTransferorTransferee(), o.getTransferorTransferee(), this::setTransferorTransferee);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityTransferBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(security, _that.getSecurity())) return false;
			if (!Objects.equals(transferorTransferee, _that.getTransferorTransferee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityTransferBreakdownBuilder {" +
				"quantity=" + this.quantity + ", " +
				"security=" + this.security + ", " +
				"transferorTransferee=" + this.transferorTransferee +
			'}';
		}
	}
}
